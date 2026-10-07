public class ExtraTest {
    public void testSearchJava() {
        Library lib = new Library(true);
        Assert.assertEquals(1, lib.search("Java").size(), "搜索Java应返回1条");
    }

    public void testSearchRuMen() {
        Library lib = new Library(true);
        Assert.assertEquals(1, lib.search("入门").size(), "搜索入门应返回1条");
    }

    public void testSearchAuthorNoMatch() {
        Library lib = new Library(true);
        Assert.assertEquals(0, lib.search("张").size(), "搜索作者张应返回0条");
    }

    public void testSearchCaseSensitive() {
        Library lib = new Library(true);
        Assert.assertEquals(0, lib.search("java").size(), "搜索java应返回0条");
    }

    public void testSearchFullName() {
        Library lib = new Library(true);
        Assert.assertEquals(1, lib.search("数据结构").size(), "搜索数据结构应返回1条");
    }

    public void testDeleteSuccess() {
        Library lib = new Library(true);
        Assert.assertEquals("删除成功", lib.deleteById(2), "删除编号2应成功");
        Assert.assertEquals(2, lib.listAll().size(), "删除后应剩余2本书");
        Assert.assertTrue(lib.findById(2) == null, "删除后按ID查询应返回null");
    }

    public void testDeleteThenAddNotReuseId() {
        Library lib = new Library(true);
        lib.deleteById(2);
        Assert.assertEquals(4, lib.add("新书", "测试", 30.0).getId(), "删2后添加新书编号应为4");
    }

    public void testDeleteAgainNotFound() {
        Library lib = new Library(true);
        lib.deleteById(2);
        Assert.assertEquals("图书编号不存在", lib.deleteById(2), "重复删除应提示不存在");
    }

    public void testDeleteAllThenAddIdContinue() {
        Library lib = new Library(true);
        lib.deleteById(1);
        lib.deleteById(2);
        lib.deleteById(3);
        Assert.assertEquals(0, lib.listAll().size(), "删空后应为0本");
        Assert.assertEquals(4, lib.add("新书", "测试", 30.0).getId(), "删空后第一本添加应为4");
        lib.deleteById(4);
        Assert.assertEquals(5, lib.add("另一本", "测试", 20.0).getId(), "继续添加应为5");
    }
}