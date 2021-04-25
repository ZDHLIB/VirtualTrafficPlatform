package services.demandservice.routerservice;

import commands.demandcommands.JTRRouterCommand;
import models.commandmodels.JTRRouterInputs;

import java.io.IOException;

public class VehDemandRouterService {

    /**
     * jtrrouter computes routes based on traffic volumes and junction turning ratios.
     * @param jtrRouterInputs
     */
    public static boolean createRouterXML(JTRRouterInputs jtrRouterInputs) {
        String command = new JTRRouterCommand(jtrRouterInputs).createCommand();

        int exitCode = 0;
        try {
            Process process = Runtime.getRuntime().exec(command);
            exitCode = process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return exitCode == 0;
    }
}
