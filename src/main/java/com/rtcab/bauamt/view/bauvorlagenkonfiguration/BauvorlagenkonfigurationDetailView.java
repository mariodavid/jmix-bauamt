package com.rtcab.bauamt.view.bauvorlagenkonfiguration;

import com.rtcab.bauamt.entity.Bauvorlagenkonfiguration;

import com.rtcab.bauamt.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "bauvorlagenkonfigurations/:id", layout = MainView.class)
@ViewController("Bauvorlagenkonfiguration.detail")
@ViewDescriptor("bauvorlagenkonfiguration-detail-view.xml")
@EditedEntityContainer("bauvorlagenkonfigurationDc")
public class BauvorlagenkonfigurationDetailView extends StandardDetailView<Bauvorlagenkonfiguration> {
}
