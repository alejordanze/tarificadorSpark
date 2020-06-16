package main.services.presenters;

import static spark.Spark.halt;
import static spark.Spark.staticFiles;

import java.io.StringWriter;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import main.Main;
import main.application.models.responseModel.ResponseModel;

public class Presenter {
	
	final static Configuration conf = new Configuration(new Version(2, 3, 0));
	
	public static StringWriter getTemplate(ResponseModel model, String template) {
		conf.setClassForTemplateLoading(Presenter.class, "/");
		
		StringWriter writer = new StringWriter();
		
        try {
            Template formTemplate = conf.getTemplate("resources/" + template);

            formTemplate.process(model.getResponse(), writer);
        } catch (Exception e) {
            halt(500);
        }

        return writer;
	}
	
	public static void run() {
		staticFiles.location("/resources");
	}

}
