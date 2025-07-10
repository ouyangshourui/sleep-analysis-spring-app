# 睡眠分析应用

这是一个基于Spring Boot的睡眠分析应用，通过摄像头拍照分析用户的睡眠状态。

## 环境要求

- Java 8 (Java SE 1.8.0_301 或更高)
- Maven 3.3+

## 编译和运行步骤

### 编译项目

在项目根目录下执行以下命令编译项目：mvn clean package
### 启动应用

编译成功后，可以通过以下两种方式启动应用：

#### 方式一：使用Maven直接运行mvn spring-boot:run
#### 方式二：通过JAR文件运行java -jar target/sleep-analysis-0.0.1-SNAPSHOT.jar
### 访问应用

应用启动后，在浏览器中访问：

[http://localhost:8080](http://localhost:8080)

## 使用说明

1. 打开网页后，系统会请求访问摄像头权限
2. 点击"拍照"按钮拍摄照片
3. 点击"分析睡眠质量"按钮上传照片进行分析
4. 系统会显示分析结果和使用的照片

## 注意事项

- 首次运行时，Maven会下载所有依赖项，可能需要一些时间
- 实际的睡眠分析需要集成专业的计算机视觉模型，本示例中使用了简单的随机判断函数作为占位
- 上传的照片会保存在项目根目录的`uploads`文件夹中

## 技术栈

- Spring Boot 2.3.12.RELEASE
- Thymeleaf模板引擎
- Maven构建工具
- HTML5/CSS/JavaScript (前端)    