/**
 * This file is part of SocialPM: Agile Project Management Tools (SocialPM) 
 *
 * Copyright (c)2010 Lincoln Baxter, III <lincoln@ocpsoft.com> (OcpSoft)
 * 
 * If you are developing and distributing open source applications under 
 * the GPL Licence, then you are free to use SocialPM under the GPL 
 * License:
 *
 * SocialPM is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * SocialPM is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with SocialPM.  If not, see <http://www.gnu.org/licenses/>.
 *  
 * For OEMs, ISVs, and VARs who distribute SocialPM with their products, 
 * host their product online, OcpSoft provides flexible OEM commercial 
 * Licences. 
 * 
 * Optionally, customers may choose a Commercial License. For additional 
 * details, contact OcpSoft (http://ocpsoft.com)
 */

package com.ocpsoft.socialpm.pages.project.admin;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.ocpsoft.socialpm.constants.UrlConstants;
import com.ocpsoft.socialpm.domain.project.Milestone;
import com.ocpsoft.socialpm.pages.PageBean;

@Named
@RequestScoped
public class ManageMilestonesBean extends PageBean
{
   private static final long serialVersionUID = 845343172591228873L;

   private Milestone milestone = new Milestone();

   public Milestone getMilestone()
   {
      return milestone;
   }

   public void setMilestone(final Milestone milestone)
   {
      this.milestone = milestone;
   }

   public String create()
   {
      ps.addMilestone(currentProjectBean.getProject(), milestone);
      return facesUtils.beautify(UrlConstants.REFRESH);
   }

   public void delete(final Milestone m)
   {
      ps.removeMilestone(currentProjectBean.getProject(), m);
      currentProjectBean.getProject().getMilestones().remove(m);
   }
}