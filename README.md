# 智慧社区 - 物业客户端 API 项目
## 项目环境
> - JDK 17
> - Spring Boot 3
> - MySQL 8

## 项目说明
### 使用说明
1. 下载maven依赖
2. `npm install` <strong style="color:red"> 安装提交插件 </strong>

### 目录说明
主要包括：
1. api-base：基础核心模块
2. api-plugin: 扩展插件模块（如文件存储、短信发送、邮件服务、定时任务等）
3. api-core: 客户端接口核心功能模块
4. api-biz: 客户端接口业务功能模块
5. api-server：服务启动模块

### 开发说明
1. 添加业务模块后，需要在 api-server 模块引入
2. 添加插件模块后，在需要使用该插件的模块引入
3. <strong style="color:red"> 代码提交使用 git cz 规范 </strong>
