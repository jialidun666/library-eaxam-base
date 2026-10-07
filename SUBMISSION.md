# 实现说明

T1：将 `search` 方法的 `equals` 改为 `contains`，仅匹配书名且区分大小写。
T2：`Library` 新增 `deleteById` 方法，删除不影响 `nextId`；`Main` 菜单新增选项 5 删除，退出选项改为 6，非法输入沿用统一提示。
T3：新增 `ExtraTest` 测试类，覆盖 `search` 5 组、删除成功、重复删除、删后编号不复用与删空延续。
测试：本地运行 `TestRunner`，输出 16 个测试全部通过，退出代码 0。