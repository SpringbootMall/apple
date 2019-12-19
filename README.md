# 项目

# 划重点：

##一、下载完后idea open直接打开pom.xml，这样就是自动适配项目文件


##二、远程更新项目代码

###2.1 将远程代码同步到本地

菜单栏VCS的Git的Reset HEAD的Reset Type类型改为Hard（强制覆盖）

然后但Git的Pull，把远程仓库的代码拉到（同步到）本地

### 2.2 将本地代码同步到远程端



--先点菜单栏右上角Git绿色打钩标志commit（要添加commit备注）

--再点菜单栏VCS找到git点击push



##三、项目下载下来无法运行解决办法：

File-->Settings-->Build,Execution,Deployment-->Build Tools-->Maven

-->Maven home directory:Bundled (Maven 3)

-->User settings file:C:\Users\自己电脑用户名\.m2\settings.xml

-->Local repository:C:\Users\自己电脑用户名\.m2\repository

##四、application.properties文件的数据库账号密码换成自己的

##五、GitHub团队项目合作流程
https://www.cnblogs.com/schaepher/p/4933873.html#fetch
注：其中 零、一、七 是由团队项目负责人来完成的。开发人员只要从 二 开始就行了。