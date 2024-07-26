# 苍穹外卖项目

这是一个完整的外卖订餐系统项目，包含前端管理端、小程序用户端、后台Java代码和Redis缓存系统。该项目提供了从用户下单到商家接单的完整流程实现。

## 项目组成

本项目由以下几个主要部分组成：

1. 前端管理端
2. 小程序用户端
3. 后台Java代码
4. MySQL数据库
5. Redis缓存数据库

## 快速开始

### 1. 前端管理端

前端代码文件：`nginx-1.20.2.zip`

使用步骤：
1. 解压 `nginx-1.20.2.zip` 文件
2. 运行 nginx 服务器

```bash
# 假设您已经解压到 nginx-1.20.2 目录
cd nginx-1.20.2
start nginx
```

### 2. 小程序用户端

小程序代码文件：`mp-weixin.zip`

使用步骤：
1. 解压 `mp-weixin.zip` 文件
2. 使用微信开发者工具打开解压后的目录
3. 在微信开发者工具中预览和调试小程序

### 3. 数据库设置

SQL文件：`sky-take-out.sql`

使用步骤：
1. 在您的MySQL数据库管理工具中创建一个新的数据库（比如名为 `sky_take_out`）
2. 导入 `sky-take-out.sql` 文件来创建所需的表格和初始数据

```sql
CREATE DATABASE sky_take_out;
USE sky_take_out;
SOURCE /path/to/sky-take-out.sql;
```

3. 配置MySQL用户名和密码
   在`application.yml`或`application-dev.yml`文件中，找到数据库配置部分，并设置正确的用户名和密码：

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/sky_take_out
    username: your_username  # 替换为您的MySQL用户名
    password: your_password  # 替换为您的MySQL密码
```

请确保使用具有适当权限的MySQL用户，能够访问和修改`sky_take_out`数据库。

### 4. 后台Java代码

后台Java代码是本项目的核心部分，负责处理业务逻辑、数据持久化和API接口等功能。

#### Maven依赖

本项目使用Maven进行依赖管理。主要的依赖包括：

- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- MySQL Connector
- Spring Boot Starter Data Redis
- 其他必要的依赖（具体依赖请查看pom.xml文件）

确保在项目根目录下有正确配置的`pom.xml`文件。

#### 配置文件

本项目包含两个主要的配置文件：

1. `application.yml`: 主配置文件，包含通用配置和生产环境配置。
2. `application-dev.yml`: 开发环境配置文件。

请根据您的环境需求适当修改这些配置文件。

#### 运行Java后端

1. 确保已安装Java JDK（推荐版本8或以上）和Maven
2. 在项目根目录下运行：

```bash
mvn spring-boot:run
```
<img width="522" alt="common层" src="https://github.com/user-attachments/assets/357b9dbe-8a12-4f12-9836-6f20ba9ff09b">
<img width="462" alt="pojo层" src="https://github.com/user-attachments/assets/e13e6fdb-f3dc-48b3-8241-04fcc5687525">
<img width="472" alt="server层" src="https://github.com/user-attachments/assets/5b5a51b3-ea38-4bee-93a5-0d2eeb71d60a">

### 5. Redis设置

本项目使用Redis进行缓存处理，提高系统性能。

1. 确保已安装并启动Redis服务器
2. 在`application.yml`或`application-dev.yml`中配置Redis连接信息：

```yaml
spring:
  redis:
    host: localhost
    port: 6379
```

3. 在Java代码中，使用`@Cacheable`, `@CachePut`, `@CacheEvict`等注解或直接使用`RedisTemplate`来操作缓存

## 系统要求

- Nginx 1.20.2
- 微信开发者工具
- MySQL 数据库
- Java JDK 8+
- Maven 3.6+
- Redis 5+

## 注意事项

- 确保所有组件都正确配置并能够相互通信
- 在实际部署时，请注意修改相关的配置文件，如数据库连接信息、Redis配置、服务器地址等
- 对于生产环境，请确保采取适当的安全措施
- 定期备份数据库和重要的业务数据


## 联系方式

如有任何问题或建议，请联系项目维护者。

---

感谢您使用苍穹外卖项目！
