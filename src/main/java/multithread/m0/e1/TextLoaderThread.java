package multithread.m0.e1;

import multithread.m0.e0.ITextLoader;

public class TextLoaderThread extends Thread {

    private final ITextLoader textLoader;

    public TextLoaderThread(ITextLoader textLoader) {
        this.textLoader = textLoader;
    }

    @Override
    public void run(){
        System.out.println(textLoader.loadText());
    }
}
