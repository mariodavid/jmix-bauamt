package com.rtcab.bauamt.view.bauvorlagenkonfiguration;

import com.rtcab.bauamt.entity.Bauvorlagenkonfiguration;

import com.rtcab.bauamt.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "bauvorlagenkonfigurations", layout = MainView.class)
@ViewController("Bauvorlagenkonfiguration.list")
@ViewDescriptor("bauvorlagenkonfiguration-list-view.xml")
@LookupComponent("bauvorlagenkonfigurationsDataGrid")
@DialogMode(width = "64em")
public class BauvorlagenkonfigurationListView extends StandardListView<Bauvorlagenkonfiguration> {
}
