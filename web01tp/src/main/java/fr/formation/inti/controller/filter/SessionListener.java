package fr.formation.inti.controller.filter;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionAttributeListener, HttpSessionListener {
	private static final Log log = LogFactory.getLog(SessionListener.class);

    /**
     * Default constructor. 
     */
    public SessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         log.debug("----> sessionCreated <----");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	log.debug("----> sessionDestroyed <----");
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
    	String attributeName = event.getName();
    	Object attributeValue = event.getValue();    	
    	log.debug("----> attributeAdded <---- name : "+attributeName+" value : "+attributeValue);
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
    	String attributeName = event.getName();
    	Object attributeValue = event.getValue();
    	log.debug("----> attributeRemoved <---- name : "+attributeName+" value : "+attributeValue);
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
    	String attributeName = event.getName();
    	Object attributeValue = event.getValue();
    	log.debug("----> attributeReplaced <---- name : "+attributeName+" value : "+attributeValue);
    }
	
}
