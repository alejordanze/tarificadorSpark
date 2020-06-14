package main.services.presenters;

import main.application.interactors.VerifyNumberClient.VerifyNumberClientBoundaryOutputPort;

public class VerifyNumberClientPresenter implements VerifyNumberClientBoundaryOutputPort{

	@Override
	public boolean present(boolean result) {
		return result;
	}

}
