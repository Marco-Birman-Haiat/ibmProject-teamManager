import { Component, Input } from '@angular/core';
import { Team } from 'src/app/entities/team';

@Component({
  selector: 'app-teams-table',
  templateUrl: './teams-table.component.html',
  styleUrls: ['./teams-table.component.css']
})
export class TeamsTableComponent {
  @Input() teamList: Team[] = [];
}
