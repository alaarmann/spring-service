package ala.task;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Task {

	@Id 
	@GeneratedValue
    private long id;
    private final String reference;

    protected Task() {
    	this("default");
    }
    
    public Task(String reference) {
        this.reference = reference;
    }

    public long getId() {
        return id;
    }
    

    public String getReference() {
        return reference;
    }

	protected void setId(long id) {
		this.id = id;
	}
}