import javax.swing.JOptionPane;

import Protocol.DriverIDC;

public class Using {
	public static void main(String[] args) throws IllegalArgumentException,
			InterruptedException {

		int rcAbrirComunicacao = 999;
		int rcFecharComunicacao = 999;
		int rcSupervisorInitialize = 999;
		int rcGetSupervisorRevision = 999;
		int rcAreaSwitch = 999;
		int rcInitializeICRW = 999;
		int rcGetStatus = 999;
		int rcMagTrackRead = 999;
		int rcEraseTracks = 999;
		int rcSetLed = 999;
		int rcGetInfoEMV = 999;
		int rcGetInfoGIE = 999;
		int rcGetPassCounter = 999;
		int rcOpenShutter = 999;
		int rcGetUserRevision = 999;
		int rcGetEMVRevision = 999;
		int rcActivateICC = 999;
		int rcDeactivateICC = 999;
		int rcStatusICC = 999;
		int rcICCcommT0 = 999;
		int rcWammResetICC = 999;
		int rcTimerSet = 999;

		// ações do case declaradas
		// bAux é a variavel equivalente a sair
		boolean bAux = true;

		// int opção para a escolha do led
		int iOpcaoLed;

		// criado o menu principal com as opcões de escolha
		while (bAux == true) {
			String sX = JOptionPane
					.showInputDialog("========Menu Principal==========" + "\n"
							+ "               Escolha uma opção: " + "\n"
							+ "==============================" + "\n"
							+ "1  - Abrir comunicação      ["
							+ rcAbrirComunicacao
							+ "]\n"
							+ "2  - Fechar comunicação     ["
							+ rcFecharComunicacao
							+ "]\n"
							+ "3  - SupervisorInitialize   ["
							+ rcSupervisorInitialize
							+ "]\n"
							+ "4  - GetSupervisorRevision  ["
							+ rcGetSupervisorRevision
							+ "]\n"
							+ "5  - AreaSwitch             ["
							+ rcAreaSwitch
							+ "]\n"
							+ "6  - InitializeICRW         ["
							+ rcInitializeICRW
							+ "]\n"
							+ "7  - GetStatus              ["
							+ rcGetStatus
							+ "]\n"
							+ "8  - MagTrackRead           ["
							+ rcMagTrackRead
							+ "]\n"
							+ "9  - EraseTracks            ["
							+ rcEraseTracks
							+ "]\n"
							+ "10 - SetLe                  ["
							+ rcSetLed
							+ "]\n"
							+ "11 - GetInfoEMV             ["
							+ rcGetInfoEMV
							+ "]\n"
							+ "12 - GetInfoGIE             ["
							+ rcGetInfoGIE
							+ "]\n"
							+ "13 - GetPassCounter         ["
							+ rcGetPassCounter
							+ "]\n"
							+ "14 - OpenShutter            ["
							+ rcOpenShutter
							+ "]\n"
							+ "15 - GetUserRevision        ["
							+ rcGetUserRevision
							+ "]\n"
							+ "16 - GetEMVRevision         ["
							+ rcGetEMVRevision
							+ "]\n"
							+ "17 - ActivateICC            ["
							+ rcActivateICC
							+ "]\n"
							+ "18 - DeactivateICC          ["
							+ rcDeactivateICC
							+ "]\n"
							+ "19 - StatusICC              ["
							+ rcStatusICC
							+ "]\n"
							+ "20 - ICCcommT0              ["
							+ rcICCcommT0
							+ "]\n"
							+ "21 - WammResetICC           ["
							+ rcWammResetICC
							+ "]\n"
							+ "22 - TimerSet               ["
							+ rcTimerSet + "]\n" + "0 - Sair \n");
			if (sX == null) {
				System.exit(0);
			}
			try {
				int iOpcao = Integer.parseInt(sX);

				switch (iOpcao) {
				case 1:
					rcAbrirComunicacao = DriverIDC.abrirComunicacao();
					if (rcAbrirComunicacao == 1) {
						System.out.println("Conectou");
						/*
						 * JOptionPane
						 * .showInputDialog("Comunicação iniciada: \n" +
						 * "1 - Voltar \n" + "2 - Fechar comunicação \n" +
						 * "3 - Mandar comando \n");
						 */
					}
					;
					break;
				case 2:
					rcFecharComunicacao = DriverIDC.FecharComunicacao();
					if (rcFecharComunicacao != 1) {
						System.out.println("Porta já estava fechada!");
					} else {
						System.out.println("Deu certo!");
					}
					break;
				case 3:
					rcSupervisorInitialize = DriverIDC.SupervisorInitialize();
					if (rcSupervisorInitialize < 0) {
						System.out
								.println("SupervisorInitialize Comunicacao falhou"
										+ rcSupervisorInitialize);
					}
					break;

				case 4:
					rcGetSupervisorRevision = DriverIDC.GetSupervisorRevision();
					if (rcGetSupervisorRevision < 0) {
						System.out
								.println("GetSupervisorRevision Comunicacao falhou"
										+ rcGetSupervisorRevision);
					}
					break;

				case 5:
					rcAreaSwitch = DriverIDC.AreaSwitch();
					if (rcAreaSwitch < 0) {
						System.out.println("AreaSwitch  Comunicacao falhou"
								+ rcAreaSwitch);
					}
					break;

				case 6:
					iOpcaoLed = Integer.parseInt(JOptionPane.showInputDialog("Digite a opcao \n"
							+ " 0-  turns LED off    \n"
							+ " 1-  turns R-LED on   \n"
							+ " 2-  turns G-LED on   \n"
							+ " 3-  turns G&R-LED on \n"
							+ " 4-  turns LED of     \n"
							+ " 5-  turns R-LED on   \n"
							+ " 6-  turns G-LED on   \n"
							+ " 7-  turns G&LED on   \n"));

					rcInitializeICRW = DriverIDC.InitializeICRW(iOpcaoLed);
					if (rcInitializeICRW < 0) {
						System.out.println("InitializeICRW  Comunicacao falhou"
								+ rcInitializeICRW);
					}
					break;

				case 7:
					rcGetStatus = DriverIDC.GetStatus();
					if (rcGetStatus < 0) {
						System.out.println("GetStatus  Comunicacao falhou"
								+ rcGetStatus);
					}
					break;

				case 8:
					rcMagTrackRead = DriverIDC.MagTrackRead();
					if (rcMagTrackRead < 0) {
						System.out.println("MagTrackRead  Comunicacao falhou"
								+ rcMagTrackRead);
					}
					break;

				case 9:
					rcEraseTracks = DriverIDC.EraseTracks();
					if (rcEraseTracks < 0) {
						System.out.println("EraseTracks  Comunicacao falhou"
								+ rcEraseTracks);
					}
					break;

				case 10:
					rcSetLed = DriverIDC.SetLed();
					if (rcSetLed < 0) {
						System.out.println("SetLed  Comunicacao falhou"
								+ rcSetLed);
					}
					break;

				case 11:
					rcGetInfoEMV = DriverIDC.GetInfoEMV();
					if (rcGetInfoEMV < 0) {
						System.out.println("GetInfoEMV  Comunicacao falhou"
								+ rcGetInfoEMV);
					}
					break;

				case 12:
					rcGetInfoGIE = DriverIDC.GetInfoGIE();
					if (rcGetInfoGIE < 0) {
						System.out.println("GetInfoGIE  Comunicacao falhou"
								+ rcGetInfoGIE);
					}
					break;

				case 13:
					rcGetPassCounter = DriverIDC.GetPassCounter();
					if (rcGetPassCounter < 0) {
						System.out.println("GetPassCounter  Comunicacao falhou"
								+ rcGetPassCounter);
					}
					break;

				case 14:
					rcOpenShutter = DriverIDC.OpenShutter();
					if (rcOpenShutter < 0) {
						System.out.println("OpenShutter  Comunicacao falhou"
								+ rcOpenShutter);
					}
					break;

				case 15:
					rcGetUserRevision = DriverIDC.GetUserRevision();
					if (rcGetUserRevision < 0) {
						System.out
								.println("GetUserRevision  Comunicacao falhou"
										+ rcGetUserRevision);
					}
					break;

				case 16:
					rcGetEMVRevision = DriverIDC.GetEMVRevision();
					if (rcGetEMVRevision < 0) {
						System.out.println("GetEMVRevision  Comunicacao falhou"
								+ rcGetEMVRevision);
					}
					break;

				case 17:
					rcActivateICC = DriverIDC.ActivateICC();
					if (rcActivateICC < 0) {
						System.out.println("ActivateICC  Comunicacao falhou"
								+ rcActivateICC);
					}
					break;

				case 18:
					rcDeactivateICC = DriverIDC.DeactivateICC();
					if (rcDeactivateICC < 0) {
						System.out.println("DeactivateICC Comunicacao falhou"
								+ rcDeactivateICC);
					}
					break;

				case 19:
					rcStatusICC = DriverIDC.StatusICC();
					if (rcStatusICC < 0) {
						System.out.println("StatusICC Comunicacao falhou"
								+ rcStatusICC);
					}
					break;

				case 20:
					rcICCcommT0 = DriverIDC.ICCcommT0();
					if (rcICCcommT0 < 0) {
						System.out.println("ICCcommT0 Comunicacao falhou"
								+ rcICCcommT0);
					}
					break;

				case 21:
					rcWammResetICC = DriverIDC.WammResetICC();
					if (rcWammResetICC < 0) {
						System.out.println("WammResetICC Comunicacao falhou"
								+ rcWammResetICC);
					}
					break;

				case 22:
					rcTimerSet = DriverIDC.TimerSet();
					if (rcTimerSet < 0) {
						System.out.println("TimerSet Comunicacao falhou"
								+ rcTimerSet);
					}
					break;
				case 0:
					System.out.println("Sair!");
					bAux = false;
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção invalida!");
					break;
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,
						"Digite apenas valores numéricos");
			}
		}

		/*
		 * int resultado = Protocol.AbrirComunicacao(); if (resultado > 0) {
		 * System.out.println("Abriu comunicação!"); } else {
		 * System.out.println("Falha!"); }
		 */
	}
}
