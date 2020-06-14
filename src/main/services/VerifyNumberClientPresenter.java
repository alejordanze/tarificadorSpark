package main.services;

import main.interactor.VerifyNumberClient.VerifyNumberClientBoundaryOutputPort;

public class VerifyNumberClientPresenter implements VerifyNumberClientBoundaryOutputPort{

	@Override
	public boolean present(boolean result) {
		return result;
	}

}
