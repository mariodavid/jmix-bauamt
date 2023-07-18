package com.rtcab.bauamt.view.entwurfsverfasser;

import com.rtcab.bauamt.entity.Entwurfsverfasser;

import com.rtcab.bauamt.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "entwurfsverfassers/:id", layout = MainView.class)
@ViewController("Entwurfsverfasser.detail")
@ViewDescriptor("entwurfsverfasser-detail-view.xml")
@EditedEntityContainer("entwurfsverfasserDc")
public class EntwurfsverfasserDetailView extends StandardDetailView<Entwurfsverfasser> {
}
