package com.mojafirma.presenter;

import com.mojafirma.model.Showing;

import java.util.List;

/**
 * Created by HP on 2017-12-04.
 */
public interface ShowingPresenter {

    Integer addShowing(Showing showing);

    void updateShowing(Showing showing);

    void removeShowing(Showing showing);

    List<Showing> getShowingList();

}
