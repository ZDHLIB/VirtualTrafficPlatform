package commands.demandcommands;

import models.commandmodels.ICommandInputs;

public class JTRRouterCommand implements IDemandCommand {
    private final ICommandInputs commandInputs;

    public JTRRouterCommand(ICommandInputs commandInputs) {
        this.commandInputs = commandInputs;
    }

    @Override
    public String createCommand() {
        return jtrrouter + this.commandInputs.createCommandInputs();
    }
}
