/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 *
 *
 *
 * @author andre
 */
package Modelo;

import java.util.HashMap;
import java.util.Map;

public class RutinaFactory implements IRutinaFactory {

    private final Map<String, IRutinaFactory> factories = new HashMap<>();

    public RutinaFactory() {
        factories.put("Bajar de peso", new RutinaBajarPesoFactory());
        factories.put("Definir", new RutinaDefinirFactory());
        factories.put("Ganar masa muscular", new RutinaGanarMasaFactory());
        factories.put("Mejorar resistencia", new RutinaMejorarResistenciaFactory());
        factories.put("Rehabilitación o movilidad", new RutinaRehabilitacionFactory());
        factories.put("Reducción de estrés", new RutinaReduccionEstresFactory());
        factories.put("Condición general", new RutinaCondicionGeneralFactory());
    }

    @Override
    public IRutina crearRutina(Usuario usuario) {
        IRutinaFactory factory = factories.get(usuario.getObjetivo());
        if (factory == null) {
            factory = factories.get("Condición general");
        }
        return factory.crearRutina(usuario);
    }
}
