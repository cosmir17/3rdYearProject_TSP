/**
 * Created by lloydp on 09/02/14.
 */
public abstract class Algorithm {
    protected NewGraphGenerator graphG;

    Algorithm(NewGraphGenerator graphG) {
        this.graphG = graphG;
    }


    abstract void run();


}
