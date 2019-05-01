package com.xsfdev.aop.aspect;

import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import com.xsfdev.aop.AopApplication;
import com.xsfdev.aop.SharedPreferenceUtil;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


/**
 * @author：xsf
 * @version: 2018/9/13
 * @Description:
 */

@Aspect
public class CheckLoginAspect {

    @Pointcut("execution(@com.app.annotation.aspect.CheckLogin * *(..))")//方法切入点
    public void methodAnnotated() {
    }

    @Around("methodAnnotated()")//在连接点进行方法替换
    public void aroundJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {


        if (!SharedPreferenceUtil.isLogin()) {
            Snackbar.make(AopApplication.getAppContext().getCurActivity().getWindow().getDecorView(), "请先登录!", Snackbar.LENGTH_LONG)
                    .setAction("登录", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            SharedPreferenceUtil.setLogin(AopApplication.getAppContext(), true);
                            Toast.makeText(AopApplication.getAppContext(), "登录成功", Toast.LENGTH_SHORT).show();
                        }
                    }).show();

            return;
        }

        joinPoint.proceed();//执行原方法
    }
}

