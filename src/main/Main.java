package main;
import static spark.Spark.*;

import static java.util.Arrays.asList;
import java.io.*;
import java.sql.Timestamp;
import java.util.*;

import main.domain.*;
import freemarker.template.*;
import main.application.gateways.Repository;
import main.dataAccess.FileRepository.CDRFileRepository;
import main.dataAccess.FileRepository.ClientFileRepository;
import main.domain.CDR;
import main.services.controllers.*;
import main.services.presenters.Presenter;

public class Main {

	public static void main(String[] args) throws Exception   {
		
		Presenter.run();
		Controller.run();
	}
}
