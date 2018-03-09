package ru.rsreu.Zhilenko0804.command.Enum;

import ru.rsreu.Zhilenko0804.command.ActionCommand;
import ru.rsreu.Zhilenko0804.command.AddConferenceCommand;
import ru.rsreu.Zhilenko0804.command.AddRequestCommand;
import ru.rsreu.Zhilenko0804.command.AddRequestFormCommand;
import ru.rsreu.Zhilenko0804.command.AddUserCommand;
import ru.rsreu.Zhilenko0804.command.DeleteConferenceCommand;
import ru.rsreu.Zhilenko0804.command.DeleteUserCommand;
import ru.rsreu.Zhilenko0804.command.LoginCommand;
import ru.rsreu.Zhilenko0804.command.LogoutCommand;
import ru.rsreu.Zhilenko0804.command.ModerViewConferenceCommand;
import ru.rsreu.Zhilenko0804.command.UserViewConferenceCommand;
import ru.rsreu.Zhilenko0804.command.ViewReportsFromConferenceCommand;
import ru.rsreu.Zhilenko0804.command.ViewUsersCommand;

public enum CommandEnum {
	LOGIN {
		{
			this.command = new LoginCommand();
		}
	},
	LOGOUT {
		{
			this.command = new LogoutCommand();
		}
	},
	VIEWUSERSCOMMAND {
		{
			this.command = new ViewUsersCommand();
		}
	},
	ADDUSERCOMMAND {
		{
			this.command = new AddUserCommand();
		}
	},
	DELETEUSERCOMMAND {
		{
			this.command = new DeleteUserCommand();
		}
	},
	USERVIEWCONFERENCECOMMAND {
		{
			this.command = new UserViewConferenceCommand();
		}
	},
	ADDREQUESTFORMCOMMAND {
		{
			this.command = new AddRequestFormCommand();
		}
	},
	ADDREQUESTCOMMAND {
		{
			this.command = new AddRequestCommand();
		}
	},
	VIEWREPORTSFROMCOMMAND {
		{
			this.command = new ViewReportsFromConferenceCommand();
		}
	},
	DELETECONFERENCECOMMAND {
		{
			this.command = new DeleteConferenceCommand();
		}
	},
	MODERVIEWCONFERENCECOMMAND {
		{
			this.command = new ModerViewConferenceCommand();
		}
	},
	ADDCONFERENCECOMMAND {
		{
			this.command = new AddConferenceCommand();
		}
	};
	ActionCommand command;

	public ActionCommand getCurrentCommand() {
		return command;
	}
}