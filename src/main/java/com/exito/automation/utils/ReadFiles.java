package com.exito.automation.utils;


import com.exito.automation.models.Modelo;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReadFiles {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReadFiles.class);
    private static final EnvironmentVariables CONF = SystemEnvironmentVariables.createEnvironmentVariables();
    private static final String CONFIG_PRODUCTS = "categories.";

    public static Modelo readProduct(String category) {

        LOGGER.info("Se crea el objeto MODELO");

        return new Modelo(
                CONF.getProperty(CONFIG_PRODUCTS + category + ".productCategory"),
                CONF.getProperty(CONFIG_PRODUCTS + category + ".productSubcategory")
        );

    }

}
