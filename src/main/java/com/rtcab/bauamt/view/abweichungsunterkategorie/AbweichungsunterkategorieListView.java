package com.rtcab.bauamt.view.abweichungsunterkategorie;

import com.rtcab.bauamt.entity.Abweichungsunterkategorie;

import com.rtcab.bauamt.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "abweichungsunterkategories", layout = MainView.class)
@ViewController("Abweichungsunterkategorie.list")
@ViewDescriptor("abweichungsunterkategorie-list-view.xml")
@LookupComponent("abweichungsunterkategoriesDataGrid")
@DialogMode(width = "64em")
public class AbweichungsunterkategorieListView extends StandardListView<Abweichungsunterkategorie> {
}
