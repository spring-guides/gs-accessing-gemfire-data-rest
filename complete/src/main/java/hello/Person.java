package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.gemfire.mapping.annotation.Region;

import lombok.Data;

@Data
@Region("People")
public class Person {

	private static AtomicLong COUNTER = new AtomicLong(0L);

	@Id
	private Long id;

	private String firstName;
	private String lastName;

	@PersistenceConstructor
	public Person() {
		this.id = COUNTER.incrementAndGet();
	}
}
