import mUnit.annotation.Test;

public class Basic {
    @Test
    public void succeedTest(){

    }

    @Test
    public void failedTest() throws Exception {
        throw new Exception("LOL");
    }
}
