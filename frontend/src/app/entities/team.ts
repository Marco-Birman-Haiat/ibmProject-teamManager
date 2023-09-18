export class Team {
  private _name: string = '';
  private _teamPlayers: string[] = [];

  public get name() {
    return this._name;
  }

  public get teamPlayers() {
    return this._teamPlayers;
  }

  public set name(name: string) {
    this._name = name;
  }
  
  public set teamPlayers(teamPlayers: string[]) {
    this._teamPlayers = teamPlayers;
  }
}