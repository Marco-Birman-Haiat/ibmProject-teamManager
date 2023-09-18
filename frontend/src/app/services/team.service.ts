import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Player } from '../entities/player';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TeamService {
  private teamEndpoint = 'http://teammanager-backend-production.up.railway.app/times'
  // private teamEndpoint = 'http://localhost:8080/times'

  constructor(private http: HttpClient) { }

  public getAllTeams(): Observable<any> {
    return this.http.get(this.teamEndpoint);
  }

}
