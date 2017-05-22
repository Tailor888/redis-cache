package pgs.redis.rediscache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pgs.redis.rediscache.model.Person;
import pgs.redis.rediscache.repository.PersonRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisCacheApplicationTests {

	@Autowired
	private PersonRepository personRepository;

	@Test
	public void testRepository() {
		personRepository.clear();

		Person pawel = new Person(1, "Paweł");
		Person marcin = new Person(1, "Marcin");
		Person magda = new Person(2, "Magda");
		Person ion = new Person(3, "Ion");
		Person tomek = new Person(4, "Tomek");

		personRepository.save(pawel);
		System.out.println(personRepository.findAll());

		personRepository.save(marcin);

		System.out.println(personRepository.findAll());

		personRepository.save(magda);
		System.out.println(personRepository.find(magda.getId()));
		magda.setName("Magdalena");
		personRepository.update(magda);
		System.out.println(personRepository.find(magda.getId()));

		personRepository.save(ion);
		personRepository.save(tomek);
		System.out.println(personRepository.findAll());
	}

}
