# React+SpringBoot学生信息管理手机端

## 一、系统功能
1. 根据学院、班级、学号、姓名动态模糊查询列表
2. 添加学生信息
3. 修改学生信息
4. 登录验证
5. 权限验证

## 二、技术选型
### 后端
1. Spring Boot 2.6.2
2. Spring Data JPA 2.6.0
3. Spring Seucrity 5.6.1
4. Lombok 1.18.22
5. Maven 3.8.1

### 前端
1. [Vite 2.7.2](https://vitejs.cn/) —— 构建项目
2. [React 17.0.2](https://react.docschina.org/) —— 核心UI库
3. [React Router 6.2.1](https://reactrouter.com/) —— 路由组件库
4. [Redux 4.1.2](http://cn.redux.js.org/) —— 状态管理库
5. [Axios 0.24.0](http://www.axios-js.com/) —— HTTP请求库
6. [Ant Design Mobile 5.0.0-rc.12](https://mobile.ant.design/zh) —— UI组件库

### 数据库
1. MySQL 8.0.27
2. Redis 6.2.6

### 开发工具
- IntelliJ IDEA 2021.3
- WebStorm 2021.3
- Navicat Premium 15
- Another Redis Desktop Manager

## 三、安装方法
### 项目结构
```
student-manager
├── student-manager     //后端
├── student-manager-ui  //前端
└── student.sql         //数据库文件
```
### 访问路径
- 后端: http://localhost:8080
- 前端: http://localhost:3000
### 安装步骤

1. 创建数据库名为`sign`，导入`student.sql`
2. 修改后端项目中的`application.yml`中数据库相关配置
3. 在前端目录里执行`yarn`或`npm install`安装相关依赖
4. 后端运行`StudentManagerApplication.java`启动
5. 前端运行`yarn dev`或`npm run dev`启动

## 四、效果预览
<img src="https://s2.loli.net/2022/01/09/1OA7FeaYMbVRTZs.png" alt="login.png" style="width:300px;">
<img src="https://s2.loli.net/2022/01/09/8psHjLtBwuaSmO1.png" alt="list.png" style="width:300px">
<img src="https://s2.loli.net/2022/01/09/aYFXbS7RcdnT5WB.png" alt="edit.png" style="width:300px">
<img src="https://s2.loli.net/2022/01/09/Zm3MUda8x2ps9PO.png" alt="add.png" style="width:300px">  
