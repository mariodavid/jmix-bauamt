package com.rtcab.bauamt.view.bauvorlage;

import com.rtcab.bauamt.entity.Bauvorlage;

import com.rtcab.bauamt.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "bauvorlages/:id", layout = MainView.class)
@ViewController("Bauvorlage.detail")
@ViewDescriptor("bauvorlage-detail-view.xml")
@EditedEntityContainer("bauvorlageDc")
public class BauvorlageDetailView extends StandardDetailView<Bauvorlage> {
}
