package org.apringframework;

/***
 * Main entry point of apring framework.
 * You can customize application start up or end event here.
 * @author Singlerr
 */
public interface ApringApplication {

    /***
     * Called on start of application.
     */
    void onApplicationStart();

    /***
     * Called on end of application.
     */
    void onApplicationStop();
}
