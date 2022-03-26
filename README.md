# NewsSystem
新闻发布平台后台系统
该系统账户分为三个等级：
1. 超级管理员 1
2. 普通账户 2
3. 管理员 3

##系统有三个模块
###1、账户管理模块
- 超级管理员
  - 可以管理所有账户（增删改查）
    - 添加账户时新添加账户默认等级为2，具有所有栏目权限
  - 更改账户等级（权限）
  - 修改账户栏目权限
  - 同时可以对栏目和新闻进行管理
- 管理员
  - 管理员只能看同级别及以下账户
  - 及对低于账户级别的账户进行管理
  - 修改账户栏目权限
  - 同时也可以对栏目和新闻进行管理
- 普通账户（注册、被添加的默认账户等级为2）
  - 只能查看自己账户信息，对本账户信息进行修改
  - 只能浏览栏目和权限以内的新闻
  - 对新闻进行发布
  - 普通账户被添加时具有所有栏目的权限


  > 展示所有账户时进行分页展示
  > 1.添加、编辑后自动返回展示首页
  > 2. 删除操作后仍在当前页面

###2、栏目模块
- 不同等级对栏目操作不同
- 只有管理员或超级管理员才有权限进行栏目操作
- 普通账户无权操作栏目
- 注册时默认具有所有栏目权限

> 栏目管理进行分页展示
> 添加、编辑后自动返回展示首页
> 删除后仍在当前页面

###3、新闻模块
- 所有账户只能在权限以内的栏目下发布新闻
- 只能查看栏目权限以内的新闻发布历史
- 只能管理栏目权限以内的新闻历史

> 新闻管理进行分页管理，初始展示所有栏目下的新闻历史
> 对新闻编辑、删除后返回新闻展示首页

###3/26补充过滤器
- 对所有请求进行过滤
  1. 对登录注册进行放行
  2. 对静态资源惊醒放行
  3. 对指定操作进行放行（无需登录就能进行的操作）
  4. 登录状态下放行  

