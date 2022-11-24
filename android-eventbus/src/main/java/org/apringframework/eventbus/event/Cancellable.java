package org.apringframework.eventbus.event;

/***
 * Marker interface indicating an event is cancellable.
 * @implNote {@link #isCancelled()} must return whether this event is cancellable or not.
 * @implNote {@link #setCancelled(boolean)} set the event to be cancelled or not.
 * @author Singlerr
 */
public interface Cancellable {

    /***
     * Whether the event is cancelled or not.
     * @return true if cancelled else false
     */
    boolean isCancelled();

    /***
     * Set the event to be cancelled or not.
     * @param cancelled true if the event must be cancelled else false
     */
    void setCancelled(boolean cancelled);
}
