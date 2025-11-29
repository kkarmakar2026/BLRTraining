import com.mphasis;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
 
@Mojo(name="hello")
public class HelloMojo extends AbstractMojo {
 
	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
 
		getLog().info("Hello Plugin Welcomes you");
	}
 
}
 