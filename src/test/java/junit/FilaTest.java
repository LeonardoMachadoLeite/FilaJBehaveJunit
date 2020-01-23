package junit;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.reporters.StoryReporterBuilder.Format;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.Assert;
import org.junit.Test;

import model.FilaEncadeada;

public class FilaTest extends JUnitStories{

	private FilaEncadeada<Integer> fila;
	
	@Given("a queue")
	public void umaFila() {
		fila = new FilaEncadeada<Integer>();
	}
	
	@When("1 is added to the queue")
	public void enfileirar() {
		fila.enfileirar(1);
	}
	
	@Then("element 1 must be added to queue")
	public void elemento1Enfileirado() {
		Assert.assertEquals(new Integer(1), fila.primeiro());
	}
	
	/* Configuration Methods */
	
	@Override
	protected List<String> storyPaths() {
		return Arrays.asList("C:\\Users\\LMLeite\\eclipse-workspace\\fila_junit_test\\src\\test\\java\\stories\\AddElementSuccessful.story");
	}

	@Override
	public Configuration configuration() {
	    return new MostUsefulConfiguration().useStoryLoader(new LoadFromClasspath(getClass().getClassLoader())).useStoryReporterBuilder(new StoryReporterBuilder().withFormats(Format.CONSOLE));
	}
	 
	@Override
	public List<CandidateSteps> candidateSteps() {
	    return new InstanceStepsFactory(configuration(), this).createCandidateSteps();
	}
	
	
	@Override
	@Test
	public void run() throws Throwable {
	    super.run();
	}
	
}
