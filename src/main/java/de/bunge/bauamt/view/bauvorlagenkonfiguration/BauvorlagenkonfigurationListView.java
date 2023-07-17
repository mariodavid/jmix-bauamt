package de.bunge.bauamt.view.bauvorlagenkonfiguration;

import de.bunge.bauamt.entity.Bauvorlagenkonfiguration;

import de.bunge.bauamt.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "bauvorlagenkonfigurations", layout = MainView.class)
@ViewController("Bauvorlagenkonfiguration.list")
@ViewDescriptor("bauvorlagenkonfiguration-list-view.xml")
@LookupComponent("bauvorlagenkonfigurationsDataGrid")
@DialogMode(width = "64em")
public class BauvorlagenkonfigurationListView extends StandardListView<Bauvorlagenkonfiguration> {
}
