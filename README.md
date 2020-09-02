# JADAdmin 通用后台管理系统
- version：0.0.1
- create：2020-08-16
- author：成应奎
- email：cxxwl96@sina.com
## 简介 
JADAdmin是一套简单通用的后台管理系统，这套JADAdmin是一套简单通用的后台管理系统，主要功能有：权限管理、菜单管理、用户管理，系统设置、实时日志，实时监控，API加密，以及登录用户修改密码、配置个性菜单等
## 技术栈
- 前端：Layui
- Java后端：SpringBoot + Thymeleaf + WebSocket + Spring Security + SpringData-Jpa + PostgreSql
## 常见问题
+ maven下载jar包长时间无反应？
    > 解决：网络原因自行解决，如果网络没问题就不要一直傻傻的等了，重启IDE，让它重新联网下载。或者更换maven仓库源为阿里源
+ IDE编译报错，识别不到实体类的set、get方法？
    > 原因：项目使用lombok开发，lombok会在生成class字节码文件帮我们生成set、get等方法，java文件没有set、get等方法，IDE索引不到set、get方法所以编译报错  
      解决：IDE安装lombok插件即可能识别到对应set、get方法，重启生效