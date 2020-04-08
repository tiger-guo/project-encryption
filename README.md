## 配置文件加密：

1. 项目启动输入 salt 并确认

2. 项目启动后发送HTTP请求:

        url：localhost:9999/encryption
        method：POST
        data:：key-value 形式


## 使用加密后配置文件内容：
1.添加POM依赖：

    <dependency>
        <groupId>com.github.ulisesbocchio</groupId>
        <artifactId>jasypt-spring-boot-starter</artifactId>
        <version>2.1.0</version>
    </dependency>
    
2.项目启动：添加配置属性进入 jasypt.encryptor.password=salt（上面加密使用的）

3.将加密配置写入，需要使用函数 ENC( param )，如：
spring.datasource.password=ENC(加密后返回的字符串)

这样就完成了所有的配置

## SpringBoot 项目优雅方式添加 salt
将启动类的main方法替换为：

    public static void main(String[] args) {
        String password;
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入加密 salt：");
        while(true){
            password = scanner.nextLine();
            System.out.print("Yes/No：");
            String flag = scanner.nextLine();
            if(flag.equals("y") || flag.equals("yes")){
                break;
            }
        }
        scanner.close();
        new SpringApplicationBuilder(SpringbootApplication.class).properties("jasypt.encryptor.password=" + password).run(args);
    }
启动时，手动输入 salt

