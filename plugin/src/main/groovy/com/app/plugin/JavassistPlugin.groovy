package com.app.plugin;

import com.android.build.gradle.AppExtension
import com.android.build.gradle.AppPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
/**
 * @author：xsf
 * @version: 2018/9/19
 * @Description:
 */
public class JavassistPlugin implements Plugin<Project> {

    void apply(Project project) {
        System.out.println("------------------JavassistPlugin开始----------------------")
        //AppExtension就是build.gradle中android{...}这一块
        def android = project.extensions.getByType(AppExtension)

        //注册一个Transform
        def classTransform = new JavassistTransform(project)
        android.registerTransform(classTransform)

        System.out.println("------------------结束了吗----------------------")
    }
}
