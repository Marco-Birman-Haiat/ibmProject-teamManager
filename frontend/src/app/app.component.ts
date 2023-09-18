import { Component } from '@angular/core';
import { PlayerService } from './services/player.service';
import { Player } from './entities/player';
import { TeamService } from './services/team.service';
import { Team } from './entities/team';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend';
  allTeamsList: Team[] = [];

  constructor(
    private playerService: PlayerService,
    private teamService: TeamService
  ) {}
  
  
  orderTeams(): void {
    this.allTeamsList.sort((a, b) => Number(a.name.split(' ')[1]) - Number(b.name.split(' ')[1]))
  }
  
  onAllocatePlayerInTeam(player: Player): void {
    this.playerService.allocatePlayerInTeam(player).subscribe({
      next: () => this.getAllTeams(),
      error: (error) => console.log(error)
    });
  }

  deleteAllTeams(): void {
    this.playerService.deleteAllPlayers().subscribe({
      next: () => {
        this.allTeamsList = [];
      },
      error: (error) => console.log(error)
    })
  }
  
  getAllTeams(): void {
    this.teamService.getAllTeams().subscribe({
      next: (response) => {
      this.allTeamsList = [];
        for (const [teamName, teamPlayers] of Object.entries(response)) {
          const team = new Team()
          team.name = teamName;
          team.teamPlayers = teamPlayers as string[];
          this.allTeamsList.push(team);
        }
        this.orderTeams();
      },
      error: (error) => {
        console.log(error);
      }
    })
  }
}
