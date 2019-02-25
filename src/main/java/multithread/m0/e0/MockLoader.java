package multithread.m0.e0;

public class MockLoader implements ITextLoader {

    private final String textLoad;

    public MockLoader(final String textLoad) {
        this.textLoad = textLoad;
    }

    public String loadText() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return textLoad;
    }
}
