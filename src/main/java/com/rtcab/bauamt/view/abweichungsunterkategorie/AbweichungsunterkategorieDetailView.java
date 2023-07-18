package com.rtcab.bauamt.view.abweichungsunterkategorie;

import com.rtcab.bauamt.entity.Abweichungsunterkategorie;

import com.rtcab.bauamt.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "abweichungsunterkategories/:id", layout = MainView.class)
@ViewController("Abweichungsunterkategorie.detail")
@ViewDescriptor("abweichungsunterkategorie-detail-view.xml")
@EditedEntityContainer("abweichungsunterkategorieDc")
public class AbweichungsunterkategorieDetailView extends StandardDetailView<Abweichungsunterkategorie> {
}
