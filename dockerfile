# 使用带glibc的Alpine镜像（解决时区等问题）
FROM eclipse-temurin:21-jdk-alpine

# 安装必要组件（时区、字体等）
RUN apk add --no-cache tzdata fontconfig \
    && ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

WORKDIR /app
COPY build/libs/abcde-0.0.3-SNAPSHOT.jar app.jar

# 优化JVM参数
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]