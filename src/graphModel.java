import com.mxgraph.model.mxGeometry;
import com.mxgraph.model.mxGraphModel;
import com.mxgraph.model.mxICell;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.util.mxPoint;
import com.mxgraph.util.mxUndoableEdit;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by lloydp on 25/02/14.
 */
public class graphModel extends mxGraphModel {

    public graphModel() {
        super();
    }

    public graphModel(Object root) {
        super(root);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public int getUpdateLevel() {
        return super.getUpdateLevel();
    }

    @Override
    public Object createRoot() {
        return super.createRoot();
    }

    @Override
    public Map<String, Object> getCells() {
        return super.getCells();
    }

    @Override
    public Object getCell(String id) {
        return super.getCell(id);
    }

    @Override
    public boolean isMaintainEdgeParent() {
        return super.isMaintainEdgeParent();
    }

    @Override
    public void setMaintainEdgeParent(boolean maintainEdgeParent) {
        super.setMaintainEdgeParent(maintainEdgeParent);
    }

    @Override
    public boolean isCreateIds() {
        return super.isCreateIds();
    }

    @Override
    public void setCreateIds(boolean value) {
        super.setCreateIds(value);
    }

    @Override
    public Object getRoot() {
        return super.getRoot();
    }

    @Override
    public Object setRoot(Object root) {
        return super.setRoot(root);
    }

    @Override
    protected Object rootChanged(Object root) {
        return super.rootChanged(root);
    }

    @Override
    protected mxUndoableEdit createUndoableEdit() {
        return super.createUndoableEdit();
    }

    @Override
    public Object[] cloneCells(Object[] cells, boolean includeChildren) {
        return super.cloneCells(cells, includeChildren);
    }

    @Override
    protected Object cloneCell(Object cell, Map<Object, Object> mapping, boolean includeChildren) throws CloneNotSupportedException {
        return super.cloneCell(cell, mapping, includeChildren);
    }

    @Override
    protected void restoreClone(Object clone, Object cell, Map<Object, Object> mapping) {
        super.restoreClone(clone, cell, mapping);
    }

    @Override
    public boolean isAncestor(Object parent, Object child) {
        return super.isAncestor(parent, child);
    }

    @Override
    public boolean contains(Object cell) {
        return super.contains(cell);
    }

    @Override
    public Object getParent(Object child) {
        return super.getParent(child);
    }

    @Override
    public Object add(Object parent, Object child, int index) {
        return super.add(parent, child, index);
    }

    @Override
    protected void cellAdded(Object cell) {
        super.cellAdded(cell);
    }

    @Override
    public String createId(Object cell) {
        return super.createId(cell);
    }

    @Override
    public Object remove(Object cell) {
        return super.remove(cell);
    }

    @Override
    protected void cellRemoved(Object cell) {
        super.cellRemoved(cell);
    }

    @Override
    protected Object parentForCellChanged(Object cell, Object parent, int index) {
        return super.parentForCellChanged(cell, parent, index);
    }

    @Override
    public int getChildCount(Object cell) {
        return super.getChildCount(cell);
    }

    @Override
    public Object getChildAt(Object parent, int index) {
        return super.getChildAt(parent, index);
    }

    @Override
    public Object getTerminal(Object edge, boolean isSource) {
        return super.getTerminal(edge, isSource);
    }

    @Override
    public Object setTerminal(Object edge, Object terminal, boolean isSource) {
        return super.setTerminal(edge, terminal, isSource);
    }

    @Override
    protected Object terminalForCellChanged(Object edge, Object terminal, boolean isSource) {
        return super.terminalForCellChanged(edge, terminal, isSource);
    }

    @Override
    public void updateEdgeParents(Object cell) {
        super.updateEdgeParents(cell);
    }

    @Override
    public void updateEdgeParents(Object cell, Object root) {
        super.updateEdgeParents(cell, root);
    }

    @Override
    public void updateEdgeParent(Object edge, Object root) {
        super.updateEdgeParent(edge, root);
    }

    @Override
    public mxPoint getOrigin(Object cell) {
        return super.getOrigin(cell);
    }

    @Override
    public Object getNearestCommonAncestor(Object cell1, Object cell2) {
        return super.getNearestCommonAncestor(cell1, cell2);
    }

    @Override
    public int getEdgeCount(Object cell) {
        return super.getEdgeCount(cell);
    }

    @Override
    public Object getEdgeAt(Object parent, int index) {
        return super.getEdgeAt(parent, index);
    }

    @Override
    public boolean isVertex(Object cell) {
        return super.isVertex(cell);
    }

    @Override
    public boolean isEdge(Object cell) {
        return super.isEdge(cell);
    }

    @Override
    public boolean isConnectable(Object cell) {
        return super.isConnectable(cell);
    }

    @Override
    public Object getValue(Object cell) {
        return super.getValue(cell);
    }

    @Override
    public Object setValue(Object cell, Object value) {
        return super.setValue(cell, value);
    }

    @Override
    protected Object valueForCellChanged(Object cell, Object value) {
        return super.valueForCellChanged(cell, value);
    }

    @Override
    public mxGeometry getGeometry(Object cell) {
        return super.getGeometry(cell);
    }

    @Override
    public mxGeometry setGeometry(Object cell, mxGeometry geometry) {
        return super.setGeometry(cell, geometry);
    }

    @Override
    protected mxGeometry geometryForCellChanged(Object cell, mxGeometry geometry) {
        return super.geometryForCellChanged(cell, geometry);
    }

    @Override
    public String getStyle(Object cell) {
        return super.getStyle(cell);
    }

    @Override
    public String setStyle(Object cell, String style) {
        return super.setStyle(cell, style);
    }

    @Override
    protected String styleForCellChanged(Object cell, String style) {
        return super.styleForCellChanged(cell, style);
    }

    @Override
    public boolean isCollapsed(Object cell) {
        return super.isCollapsed(cell);
    }

    @Override
    public boolean setCollapsed(Object cell, boolean collapsed) {
        return super.setCollapsed(cell, collapsed);
    }

    @Override
    protected boolean collapsedStateForCellChanged(Object cell, boolean collapsed) {
        return super.collapsedStateForCellChanged(cell, collapsed);
    }

    @Override
    public boolean isVisible(Object cell) {
        return super.isVisible(cell);
    }

    @Override
    public boolean setVisible(Object cell, boolean visible) {
        return super.setVisible(cell, visible);
    }

    @Override
    protected boolean visibleStateForCellChanged(Object cell, boolean visible) {
        return super.visibleStateForCellChanged(cell, visible);
    }

    @Override
    public void execute(mxAtomicGraphModelChange change) {
        super.execute(change);
    }

    @Override
    public void beginUpdate() {
        super.beginUpdate();
    }

    @Override
    public void endUpdate() {
        super.endUpdate();
    }

    @Override
    public void mergeChildren(mxICell from, mxICell to, boolean cloneAllEdges) throws CloneNotSupportedException {
        super.mergeChildren(from, to, cloneAllEdges);
    }

    @Override
    protected void mergeChildrenImpl(mxICell from, mxICell to, boolean cloneAllEdges, Hashtable<Object, Object> mapping) throws CloneNotSupportedException {
        super.mergeChildrenImpl(from, to, cloneAllEdges, mapping);
    }

    @Override
    public Object getEventSource() {
        return super.getEventSource();
    }

    @Override
    public void setEventSource(Object value) {
        super.setEventSource(value);
    }

    @Override
    public boolean isEventsEnabled() {
        return super.isEventsEnabled();
    }

    @Override
    public void setEventsEnabled(boolean eventsEnabled) {
        super.setEventsEnabled(eventsEnabled);
    }

    @Override
    public void addListener(String eventName, mxIEventListener listener) {
        super.addListener(eventName, listener);
    }

    @Override
    public void removeListener(mxIEventListener listener) {
        super.removeListener(listener);
    }

    @Override
    public void removeListener(mxIEventListener listener, String eventName) {
        super.removeListener(listener, eventName);
    }

    @Override
    public void fireEvent(mxEventObject evt) {
        super.fireEvent(evt);
    }

    @Override
    public void fireEvent(mxEventObject evt, Object sender) {
        super.fireEvent(evt, sender);
    }

    /**
     * Returns a hash code value for the object. This method is
     * supported for the benefit of hash tables such as those provided by
     * {@link java.util.HashMap}.
     * <p/>
     * The general contract of {@code hashCode} is:
     * <ul>
     * <li>Whenever it is invoked on the same object more than once during
     * an execution of a Java application, the {@code hashCode} method
     * must consistently return the same integer, provided no information
     * used in {@code equals} comparisons on the object is modified.
     * This integer need not remain consistent from one execution of an
     * application to another execution of the same application.
     * <li>If two objects are equal according to the {@code equals(Object)}
     * method, then calling the {@code hashCode} method on each of
     * the two objects must produce the same integer result.
     * <li>It is <em>not</em> required that if two objects are unequal
     * according to the {@link Object#equals(Object)}
     * method, then calling the {@code hashCode} method on each of the
     * two objects must produce distinct integer results.  However, the
     * programmer should be aware that producing distinct integer results
     * for unequal objects may improve the performance of hash tables.
     * </ul>
     * <p/>
     * As much as is reasonably practical, the hashCode method defined by
     * class {@code Object} does return distinct integers for distinct
     * objects. (This is typically implemented by converting the internal
     * address of the object into an integer, but this implementation
     * technique is not required by the
     * Java<font size="-2"><sup>TM</sup></font> programming language.)
     *
     * @return a hash code value for this object.
     * @see Object#equals(Object)
     * @see System#identityHashCode
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * <p/>
     * The {@code equals} method implements an equivalence relation
     * on non-null object references:
     * <ul>
     * <li>It is <i>reflexive</i>: for any non-null reference value
     * {@code x}, {@code x.equals(x)} should return
     * {@code true}.
     * <li>It is <i>symmetric</i>: for any non-null reference values
     * {@code x} and {@code y}, {@code x.equals(y)}
     * should return {@code true} if and only if
     * {@code y.equals(x)} returns {@code true}.
     * <li>It is <i>transitive</i>: for any non-null reference values
     * {@code x}, {@code y}, and {@code z}, if
     * {@code x.equals(y)} returns {@code true} and
     * {@code y.equals(z)} returns {@code true}, then
     * {@code x.equals(z)} should return {@code true}.
     * <li>It is <i>consistent</i>: for any non-null reference values
     * {@code x} and {@code y}, multiple invocations of
     * {@code x.equals(y)} consistently return {@code true}
     * or consistently return {@code false}, provided no
     * information used in {@code equals} comparisons on the
     * objects is modified.
     * <li>For any non-null reference value {@code x},
     * {@code x.equals(null)} should return {@code false}.
     * </ul>
     * <p/>
     * The {@code equals} method for class {@code Object} implements
     * the most discriminating possible equivalence relation on objects;
     * that is, for any non-null reference values {@code x} and
     * {@code y}, this method returns {@code true} if and only
     * if {@code x} and {@code y} refer to the same object
     * ({@code x == y} has the value {@code true}).
     * <p/>
     * Note that it is generally necessary to override the {@code hashCode}
     * method whenever this method is overridden, so as to maintain the
     * general contract for the {@code hashCode} method, which states
     * that equal objects must have equal hash codes.
     *
     * @param obj the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj
     * argument; {@code false} otherwise.
     * @see #hashCode()
     * @see java.util.HashMap
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * Creates and returns a copy of this object.  The precise meaning
     * of "copy" may depend on the class of the object. The general
     * intent is that, for any object {@code x}, the expression:
     * <blockquote>
     * <pre>
     * x.clone() != x</pre></blockquote>
     * will be true, and that the expression:
     * <blockquote>
     * <pre>
     * x.clone().getClass() == x.getClass()</pre></blockquote>
     * will be {@code true}, but these are not absolute requirements.
     * While it is typically the case that:
     * <blockquote>
     * <pre>
     * x.clone().equals(x)</pre></blockquote>
     * will be {@code true}, this is not an absolute requirement.
     *
     * By convention, the returned object should be obtained by calling
     * {@code super.clone}.  If a class and all of its superclasses (except
     * {@code Object}) obey this convention, it will be the case that
     * {@code x.clone().getClass() == x.getClass()}.
     *
     * By convention, the object returned by this method should be independent
     * of this object (which is being cloned).  To achieve this independence,
     * it may be necessary to modify one or more fields of the object returned
     * by {@code super.clone} before returning it.  Typically, this means
     * copying any mutable objects that comprise the internal "deep structure"
     * of the object being cloned and replacing the references to these
     * objects with references to the copies.  If a class contains only
     * primitive fields or references to immutable objects, then it is usually
     * the case that no fields in the object returned by {@code super.clone}
     * need to be modified.
     *
     * The method {@code clone} for class {@code Object} performs a
     * specific cloning operation. First, if the class of this object does
     * not implement the interface {@code Cloneable}, then a
     * {@code CloneNotSupportedException} is thrown. Note that all arrays
     * are considered to implement the interface {@code Cloneable} and that
     * the return type of the {@code clone} method of an array type {@code T[]}
     * is {@code T[]} where T is any reference or primitive type.
     * Otherwise, this method creates a new instance of the class of this
     * object and initializes all its fields with exactly the contents of
     * the corresponding fields of this object, as if by assignment; the
     * contents of the fields are not themselves cloned. Thus, this method
     * performs a "shallow copy" of this object, not a "deep copy" operation.
     *
     * The class {@code Object} does not itself implement the interface
     * {@code Cloneable}, so calling the {@code clone} method on an object
     * whose class is {@code Object} will result in throwing an
     * exception at run time.
     *
     * @return a clone of this instance.
     * @throws CloneNotSupportedException if the object's class does not
     *                                    support the {@code Cloneable} interface. Subclasses
     *                                    that override the {@code clone} method can also
     *                                    throw this exception to indicate that an instance cannot
     *                                    be cloned.
     * @see Cloneable
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p/>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Called by the garbage collector on an object when garbage collection
     * determines that there are no more references to the object.
     * A subclass overrides the {@code finalize} method to dispose of
     * system resources or to perform other cleanup.
     * <p/>
     * The general contract of {@code finalize} is that it is invoked
     * if and when the Java<font size="-2"><sup>TM</sup></font> virtual
     * machine has determined that there is no longer any
     * means by which this object can be accessed by any thread that has
     * not yet died, except as a result of an action taken by the
     * finalization of some other object or class which is ready to be
     * finalized. The {@code finalize} method may take any action, including
     * making this object available again to other threads; the usual purpose
     * of {@code finalize}, however, is to perform cleanup actions before
     * the object is irrevocably discarded. For example, the finalize method
     * for an object that represents an input/output connection might perform
     * explicit I/O transactions to break the connection before the object is
     * permanently discarded.
     * <p/>
     * The {@code finalize} method of class {@code Object} performs no
     * special action; it simply returns normally. Subclasses of
     * {@code Object} may override this definition.
     * <p/>
     * The Java programming language does not guarantee which thread will
     * invoke the {@code finalize} method for any given object. It is
     * guaranteed, however, that the thread that invokes finalize will not
     * be holding any user-visible synchronization locks when finalize is
     * invoked. If an uncaught exception is thrown by the finalize method,
     * the exception is ignored and finalization of that object terminates.
     * <p/>
     * After the {@code finalize} method has been invoked for an object, no
     * further action is taken until the Java virtual machine has again
     * determined that there is no longer any means by which this object can
     * be accessed by any thread that has not yet died, including possible
     * actions by other objects or classes which are ready to be finalized,
     * at which point the object may be discarded.
     * <p/>
     * The {@code finalize} method is never invoked more than once by a Java
     * virtual machine for any given object.
     * <p/>
     * Any exception thrown by the {@code finalize} method causes
     * the finalization of this object to be halted, but is otherwise
     * ignored.
     *
     * @throws Throwable the {@code Exception} raised by this method
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
