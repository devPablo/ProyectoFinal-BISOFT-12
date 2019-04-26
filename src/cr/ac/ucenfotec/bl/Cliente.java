package cr.ac.ucenfotec.bl;

import java.util.ArrayList;

import cr.ac.ucenfotec.bl.tablero.ITablero;
import cr.ac.ucenfotec.state.State;
import cr.ac.ucenfotec.state.TurnPlayerOne;
import cr.ac.ucenfotec.state.TurnPlayerTwo;

public class Cliente {
	private ITablero juego;
	private ArrayList<Jugador> jugadores;
	private State playerOneState;
	private State playerTwoState;
	private static Cliente instanciaUnica;


	private State activePlayer = new TurnPlayerOne(this);
	
	public Cliente() {
		jugadores = new ArrayList<Jugador>();
		playerOneState = new TurnPlayerOne(this);
		playerTwoState = new TurnPlayerTwo(this);
	}

	public Cliente(ArrayList<Jugador> _jugadores) {
		this.jugadores = _jugadores;
	}

	private static Cliente getInstance(){
		if(instanciaUnica == null){
			instanciaUnica = new Cliente();
		}
		return instanciaUnica;
	}

	public void iniciarPartida(String tipoJuego) {
		//Validar el tipo de juego.
		
		//Si tipo Juego == "Ajedrez", crear un tablero de tipo Ajedrez.
		//Si tipo Juego == "Damas", crear un tablero de tipo Damas.
		//Si tipo Go == "Go", crear un tablero de tipo Go.
	}
	
	public boolean autenticarJugador(String name) {
		for(Jugador x : jugadores) {
			if(x.getName() == name)
				return true;
		}
		return false;
	}
	
	public void nextTurn() {
		activePlayer.nextTurn();
		
		for(int i = 0; i < jugadores.size(); i++) {
			if(i == 0 && this.activePlayer == getPlayerOneState()) {
				jugadores.get(i).setTurn(true);
				jugadores.get(i + 1).setTurn(false);
			}else if(i == 1 && this.activePlayer == getPlayerTwoState()) {
				jugadores.get(i).setTurn(true);
				jugadores.get(i - 1).setTurn(false);
			}
		}
	}
	
	public State getPlayerOneState() {
		return playerOneState;
	}
	
	public State getPlayerTwoState() {
		return playerTwoState;
	}
	
	public void setState(State _state) {
		this.activePlayer = _state;
	}
	
	public State getState() {
		return this.activePlayer;
	}
	
	public void setJugadores(ArrayList<Jugador> _jugadores) {
		this.jugadores = _jugadores;
	}
}
