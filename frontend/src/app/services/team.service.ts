import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Player } from '../entities/player';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TeamService {
  private playersEndpoint = 'http://localhost:8080/times'

  constructor(private http: HttpClient) { }

  public getAllTeams(): Observable<any> {
    return this.http.get(this.playersEndpoint);
  }

}
