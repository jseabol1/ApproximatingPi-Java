public class SimpleMethodTimer {

    private final long startTime;

    public SimpleMethodTimer()
    {
        this.startTime = System.currentTimeMillis();
    }

    public long getMilliRuntime(){
        return (System.currentTimeMillis() - startTime);
    }

    @Override
    public String toString()
    {
        return String.valueOf(getMilliRuntime());
    }
}
