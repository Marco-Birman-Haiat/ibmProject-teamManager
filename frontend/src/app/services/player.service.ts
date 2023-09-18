import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Player } from '../entities/player';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {
  private playersEndpoint = 'http://teammanager-backend-production.up.railway.app/jogadores'
  // private playersEndpoint = 'http://localhost:8080/jogadores'

  constructor(private http: HttpClient) { }

  public allocatePlayerInTeam(newPlayer: Player): Observable<any> {
    return this.http.post(this.playersEndpoint, newPlayer);
  }

  public deleteAllPlayers(): Observable<any> {
    return this.http.delete(this.playersEndpoint + "/all");
  }
}
