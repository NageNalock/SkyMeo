# MybatisGenerator

目前分类管理中Mybatis中相关类都是自己手动编写的，包括：Category.java, CategoryMapper.java和CategoryMapper.xml。

尤其是CategoryMapper.xml里面主要是SQL语句，可以预见在接下来的开发任务中，随着业务逻辑的越来越复杂，SQL语句也会越来越复杂，进而导致开发速度降低，出错率增加，维护成本上升等问题。

为了解决手动编写SQL语句效率低这个问题，我们对Mybatis部分的代码，使用逆向工程进行重构。

所谓的逆向工程，就是在已经存在的**数据库表结构**基础上，通过工具，自动生成Category.java, CategoryMapper.java和CategoryMapper.xml。